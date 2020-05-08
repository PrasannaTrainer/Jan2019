filename=input("Enter FileName with Path ")
try:
  obj = open(filename,"r")
  if obj:
    print("File Opened successfully...")
    for c in obj:
        print(c)
    #print(content)
    #print(type(content))
    obj.close()
except PermissionError:
    print("Sorry Drive No Permission")
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")