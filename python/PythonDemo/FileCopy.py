srcFile = input("Enter FileName with Path (source File) ")
tarFile = input("Enter FileName with Path (Target File)  ")

try:
  obj = open(srcFile, "r")
  tar = open(tarFile, "w")
  if obj:
    print("File Opened successfully...")
    for c in obj:
        print(c)
        tar.write(c)
    #print(content)
    #print(type(content))
    obj.close()
    tar.close()
    print("File Copied Successfully")
except PermissionError:
    print("Sorry Drive No Permission")
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")