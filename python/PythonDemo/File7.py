filename=input("Enter FileName with Path ")
try:
  obj = open(filename)
  if obj:
    print("File Opened successfully...")
    print("File Pointer Position is  ", obj.tell())
    print("First Line Content is ", obj.readline())
    obj.seek(30)
    print("File Pointer Position is ", obj.tell())
    print("Content After 30 bytes ", obj.readline())
    obj.close()
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")