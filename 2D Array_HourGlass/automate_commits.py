import os
import subprocess
from datetime import datetime, timedelta

# Configuration
repo_path = r'C:\Users\User\Documents\Code\JavaProjects\Java'
commit_message = 'Add difficult Java data structure code'
start_date = datetime(2024, 5, 25)
end_date = datetime(2024, 7, 5)
files_per_day = 10

def git_commit(file_list, commit_date):
    os.chdir(repo_path)
    for file in file_list:
        subprocess.run(['git', 'add', file], check=True)
    subprocess.run(['git', 'commit', '-m', f"{commit_message} for {commit_date.strftime('%Y-%m-%d')}"], check=True)
    subprocess.run(['git', 'push'], check=True)

def main():
    current_date = start_date
    file_index = 0
    all_files = [f for f in os.listdir(repo_path) if os.path.isfile(os.path.join(repo_path, f))]
    
    while current_date <= end_date:
        files_to_commit = all_files[file_index:file_index + files_per_day]
        if files_to_commit:
            git_commit(files_to_commit, current_date)
        file_index += files_per_day
        current_date += timedelta(days=1)

if __name__ == "__main__":
    main()
