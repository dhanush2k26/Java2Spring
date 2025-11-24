# Script to identify tracked files that should be ignored and optionally untrack them
# Usage: run in repository root in PowerShell

$patterns = @(
    '^(.*/)?target(/.*)?$',
    '\.class$',
    '\.jar$',
    '\.log$',
    '(^|/)\.idea(/|$)',
    '\.iml$',
    '^(.*/)?\.metadata(/.*)?$'
)

Write-Host "Scanning repository for tracked files matching common ignore patterns..." -ForegroundColor Cyan
$toRemove = @()
foreach ($p in $patterns) {
    $matches = git ls-files | Where-Object { $_ -match $p }
    if ($matches) {
        Write-Host "Pattern: $p - Found: " -NoNewline; Write-Host ($matches.Count) -ForegroundColor Yellow
        $toRemove += $matches
    }
}

if ($toRemove.Count -eq 0) {
    Write-Host "No tracked files matching the patterns were found. Nothing to untrack." -ForegroundColor Green
    exit 0
}

Write-Host "The following tracked files were found and are recommended to be untracked:" -ForegroundColor Red
$toRemove | ForEach-Object { Write-Host $_ }

$confirm = Read-Host "Do you want to untrack (git rm --cached) these files now? (y/N)"
if ($confirm -ne 'y' -and $confirm -ne 'Y') {
    Write-Host "No changes made. If you want to remove these files from the repo, run the commands below or re-run this script and choose 'y'." -ForegroundColor Yellow
    Write-Host "Sample commands (review before running):"
    $toRemove | ForEach-Object { Write-Host "git rm --cached --ignore-unmatch '$_'" }
    exit 0
}

Write-Host "Untracking files..." -ForegroundColor Cyan
foreach ($f in $toRemove | Select-Object -Unique) {
    git rm --cached --ignore-unmatch "$f"
}

Write-Host "Done; review with git status, then commit. For example: git commit -m 'Remove tracked build artifacts'" -ForegroundColor Green
