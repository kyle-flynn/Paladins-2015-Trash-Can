## Paladin's 2015 on-board roboRio Vision code
Initial code cloned from [Team 2168's vision work] 
(https://github.com/Team2168/2168_Vision_Example)

After each compile, the binary (Rio_Beagle/3618_Vision) needs to be transfered
to the roboRio.  To this end, a helper script (download.sh) is in the project
folder and can be executed at a GitBash prompt: `./download.sh`

## Setup X11
Much of the work needs to take place in the roboRio's Linux environment, which can be reached by logging into the device using ssh (from Linux or Mac) or [PuTTY](http://www.chiark.greenend.org.uk/~sgtatham/putty/download.html) (from Windows) into `admin` on the roboRio.  Connect using the IP address of the roboRio or the host name `roborio-3618.local`:

`ssh admin@roborio-3618.local`

X11 Forwarding (X Windows) can be enabled to 'push' graphical/interactive programs to another computer.  In this case, it is possible to have programs run on the roboRio and put graphical content on a connected (Windows) computer.

Since the roboRio is an ARM processor based on soft VFP registers with NEON instruction support, we can use any binary that has been compiled for ArmV7 with softFP (for example, the [BeagleBone family] (http://beagleboard.org/bone)).

To this end, we need to add the Angstrom repository to the list of sites `opkg` can pull 3rd party applications from, then X11 can be installed:

1. Use VI to create a new feed source for opkg: `vi /etc/opkg/angstrom-base-feed.conf`
2. Hit the `i` button on your keyboard to enter insert mode in vi
3. Paste this line into the file: `src/gz angstrom-base http://feeds.angstrom-distribution.org/feeds/next/ipk/eglibc/armv7a/base/`
4. Hit the `esc` button on your keyboard to exit insert mode in vi
5. Type `:wq` and hit enter to save the file and exit VI
6. You should now be back at the terminal prompt $
7. type `opkg update`
8. If connected to the Internet, your RoboRio will now download the list of angstrom packages you can safely install on your RoboRio.
9. use `opkg install xauth` to install X11 on the RoboRio
10. modify the sshd config file: `vi /etc/ssh/sshd_config`
11. hit `i` on the keyboard to enter insert mode
12. add the following 2 lines to the end of the file:  
`X11Forwarding yes`  
`X11UseLocalhost yes`
13. hit `esc` on the keyboard
14. type `:wq` and hit enter to save and exit
15. You should now be back at the prompt
16. restart the sshd server: `/etc/init.d/sshd reload`
17. kill the connection by typing `exit`
18. Install and run an X-Windows Server [like Xming] (http://sourceforge.net/projects/xming/)
19. SSH into it again with X11 forwarding: `ssh -Y admin@roborio-3618.local` (on linux/mac) or by enabling X11 forwarding on PuTTY under connection->ssh->X11
20. If done correctly, there will be no X11 error once logged in
You may see /usr/bin/xauth: file /home/admin/.Xauthority does not exist
Thats a good thing, it means the rio created a ssh for your computer
21. You can now run a gui application (like our 3618_Vision application with the "-v" option), and it will use x11 forwarding to show up on your development computer

Other `opkg` things you can use:  
* `opkg upgrade <package>` to upgrade packages  
* `opkg list-installed` to see what you already have installed on the RoboRio  
* `opkg search <package>` to see what you can install from the Angstrom repo onto the RoboRio.

## Execution
`cd ../lvuser/Vision`
`./3818_Vision [-t] [-u] [-v] [-w] [-f image_name] [-c IP_of_camera]`  
* `-u` specifies USB camera.  
* `-f image_name` specifies a file to be processed  
* `-c IP_of_camera` gets images from an IP camera (Axis?) at the specified address  
* `-t` requests Timing stats to be displayed to the console.  
* `-v` enables Viewing the output over X11 to the host (connected) computer.  
* `-w` enables Web output.  This exposes a snapshot made available off the roboRio's web page at [http://roborio-3618.local/WIF/Core/Image.jpg] (http://roborio-3618.local/WIF/Core/Image.jpg) updated at one second intervals.

