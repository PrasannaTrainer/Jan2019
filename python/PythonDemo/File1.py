filename=input("Enter FileName with Path ")
try:
  obj = open(filename)
  if obj:
    print("File Opened successfully...")
    obj.close()
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")