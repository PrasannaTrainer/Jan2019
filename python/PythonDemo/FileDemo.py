filename=input("Enter FileName with Path ")
try:
  obj = open(filename, "a")
  if obj:
    obj.write("This is New Content...")
    obj.close()
except PermissionError:
    print("Sorry Drive No Permission")
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")