filename=input("Enter FileName with Path ")
try:
    with open(filename, "r") as obj:
        if obj:
            print("File Opened successfully...")
            obj.close()
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")