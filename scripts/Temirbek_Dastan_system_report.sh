#!/bin/bash

# Personal system monitoring report
# Student: Dastan Temirbek

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(dirname "$SCRIPT_DIR")"
LOG_FILE="$PROJECT_DIR/logs/Temirbek_Dastan_system_report.log"

{
    echo "========================================"
    echo "System Report - Dastan Temirbek"
    echo "========================================"

    echo "Date and Time: $(date '+%Y-%m-%d %H:%M:%S %Z')"
    echo "Username: $(whoami)"

    echo
    echo "--- Operating System ---"
    grep '^PRETTY_NAME=' /etc/os-release
    uname -r

    echo
    echo "--- CPU Information ---"
    lscpu | grep -E '^(Architecture|CPU\(s\)|Model name):'

    echo
    echo "--- Memory Information ---"
    free -h

    echo
    echo "--- Disk Usage ---"
    df -h "$PROJECT_DIR"

    echo
    echo "--- Available Disk Space ---"
    df -h --output=avail "$PROJECT_DIR"

    echo "========================================"
    echo

} | tee -a "$LOG_FILE"
