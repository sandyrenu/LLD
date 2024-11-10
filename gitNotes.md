

#git reset --soft HEAD~1
#--soft keeps the changes in the staging area, so you can modify them and recommit if needed.

#git reset --hard HEAD~1
#--hard discards the changes entirely, so only use this if you’re sure you don’t need the changes from the last commit.

# git restore <file>...
# to unstage from working directory

git rebase -i HEAD~3
This command opens an editor showing the last 3 commits in reverse order. It might look something like this:

plaintext
Copy code
pick a1b2c3d Commit message 1
pick d4e5f6g Commit message 2
pick h7i8j9k Commit message 3
Step 2: Mark Commits for Squashing
Change the word pick to squash (or just s) for the commits you want to combine with the top commit. Only the first commit should keep pick:

plaintext
Copy code
pick a1b2c3d Commit message 1
squash d4e5f6g Commit message 2
squash h7i8j9k Commit message 3
Save and close the editor. Git will then start the rebase process and ask you to edit the commit message for the combined commit.

Step 3: Edit the Combined Commit Message
You’ll see an editor with all commit messages combined. You can edit this message to summarize the purpose of the new, single commit.

Save and close the editor to finish the rebase.

Step 4: Push the Changes
If you’ve already pushed the previous commits to a remote repository, you’ll need to force-push the changes to update the remote history:

bash
Copy code
git push --force origin main  # Replace "main" with your branch name if different