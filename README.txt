NumberToArabicWords


converting Arabic numbers to words, e.g., 314 => ثلاثمائة و أربع عشرة


http://localhost:8080/convertToArabicWords

try testing either using:

{
  "number": "622335555"
}

or 

{
  "number": "622335555"
  "isFeminine": <False|True>
}

- You can pass a parameter that indicates whether the number is for a muscular or a feminine to my service.
- If you didn't specify that field, the default one is muscular.