filename=input("Enter FileName with Path ")
try:
  obj = open(filename)
  if obj:
    print("File Opened successfully...")
    content = obj.readline()
    print(content)
    print(type(content))
    obj.close()
except PermissionError:
    print("Sorry Drive No Permission")
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")