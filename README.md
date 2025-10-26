# 📝 FileReaderWriter (Java)

A simple **Java console application** for reading and writing text files with automatic **timestamps**.  
It lets users write timestamped notes or messages into a text file and later read them back — all from the terminal.

---

## 🚀 Features

- ✅ Create or append to any text file  
- 🕒 Auto-timestamped entries using `LocalDateTime`  
- 📖 Read saved content directly from the file  
- 💬 Simple interactive menu  
- ⚙️ Handles missing files and I/O errors gracefully  

---

## 🧠 How It Works

1. When you start the program, it asks for a **filename** (without extension).  
2. You’ll see a **menu**:
   - `1️⃣` Write to file  
   - `2️⃣` Read file  
   - `3️⃣` Exit  

3. When writing, each line is saved with a timestamp.  
   - Type `exit` when you’re done writing.  

4. When reading, the file’s contents (with timestamps) are displayed in the terminal.

---

## 💻 Example Output

```bash
Enter filename (without extension): notes

--- MENU ---
1️⃣  Write to file
2️⃣  Read file
3️⃣  Exit
Choose an option: 1
Type your lines (type 'exit' to stop writing):
Meeting with team at 10AM
exit
✅ Lines saved successfully to notes.txt

--- MENU ---
1️⃣  Write to file
2️⃣  Read file
3️⃣  Exit
Choose an option: 2

--- Reading from notes.txt ---
[2025-10-26 14:03:12] Meeting with team at 10AM
