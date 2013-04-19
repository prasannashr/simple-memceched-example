Using Memcached with Java on Windows

Windows Memcached software is available on this page inside 
memcached-server-for-window/ folder.

Download the file (memcached.exe) in a directory of choice and then do the following to install memcached as a service.

c:/bin/memcached.exe  -d install

At this point the service is installed, it can started or stopped using the following commands

c:/bin/memcached.exe -d  start
c:/bin/memcached.exe -d  stop

By default, the memcached service has a limit of 64MB. If that is not enough, you can increase by tweaking the Windows Registry. Open the following entry.

HKEY_LOCAL_MACHINE/SYSTEM/CurrentControlSet/Services/memcached Server

Locate the entry called ImagePath. To increase the limit to 128MB set the value to…

“c:/bin/memcached.exe” -d runservice -m 512


Reference from http://glassonionblog.wordpress.com/2012/02/16/using-memcached-with-java-on-window/