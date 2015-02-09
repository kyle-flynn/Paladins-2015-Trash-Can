# Paladin's 2015 on-board roboRio Vision code
Initial code cloned from [Team 2168's vision work] 
(https://github.com/Team2168/2168_Vision_Example)

After each compile, the binary (Rio_Beagle/3618_Vision) needs to be transfered
to the roboRio.  To this end, a helper script (download.sh) is in the project
folder and can be executed at a GitBash prompt: `./download.sh`

# Setup
Need to find the mpegstreamer software that was installed on the pi,
which can expose the frames (raw or processed) coming from the application
to most web browser clients.

# Execution
ssh (or puTTy) into `admin` on the roboRio:
`cd ../lvuser/Vision`
`./3818_Vision [-t] [-u] `

# Debugging
Available through port 8080.  I