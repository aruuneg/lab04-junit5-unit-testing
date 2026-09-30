\# Лаборатори №4: JUnit 5 ашиглан нэгжийн тест бичих



\## Оюутны мэдээлэл



\- Нэр: ANAR BATBOLD

\- Оюутны код: B170910823

\- Хичээл: F.CSA313 Программ хангамжийн чанарын баталгаа ба тест



\---



\## 1. Ашигласан орчин



\### Java хувилбар



```text

Java version: 21.0.12.1

Vendor: Eclipse Adoptium

```



\### Maven хувилбар



```text

Apache Maven 3.9.16

Maven home: C:\\apache-maven-3.9.16

Java version: 21.0.12.1

OS: Windows 11

Architecture: amd64

```



\### Тестийн framework



```text

JUnit 5

```



Төслийг Maven ашиглан build хийж, JUnit 5 ашиглан нэгжийн тестүүдийг ажиллуулсан.



\---



\## 2. Төслийн бүтэц



```text

lab04/

├── pom.xml

├── README.md

├── .gitignore

├── src/

│   ├── main/

│   │   └── java/

│   │       └── GradeCalculator.java

│   └── test/

│       └── java/

│           └── GradeCalculatorTest.java

└── results/

&#x20;   ├── mvn-test.txt

&#x20;   └── mvn-test-mutant.txt

```



`target/` хавтас нь Maven-ийн build output тул `.gitignore` файлд оруулсан.



\---



\## 3. GradeCalculator



Энэхүү лабораторийн ажлаар оюутны нийт оноо болон үсгэн дүнг тооцдог `GradeCalculator` классыг тестэлсэн.



Класс нь үндсэн хоёр үйлдэлтэй:



\- `letterGrade(double score)`

\- `totalScore(...)`



\### Үсгэн дүнгийн дүрэм



| Оноо | Үсгэн дүн |

|---:|:---|

| 90-100 | A |

| 80-89.99 | B |

| 70-79.99 | C |

| 60-69.99 | D |

| 0-59.99 | F |



`score` нь 0-100 хязгаараас гарсан тохиолдолд `IllegalArgumentException` үүснэ.



\### Нийт онооны бүтэц



| Бүрэлдэхүүн | Дээд оноо |

|---|---:|

| Ирц | 10 |

| Лаборатори ба бие даалт | 40 |

| Сорил 1 | 10 |

| Сорил 2 | 10 |

| Шалгалт | 30 |

| \*\*Нийт\*\* | \*\*100\*\* |



Аль нэг бүрэлдэхүүний оноо 0-ээс бага эсвэл зөвшөөрөгдсөн дээд хэмжээнээс их байвал `IllegalArgumentException` үүснэ.



\---



\## 4. Нэгжийн тестүүд



Тестүүдийг `GradeCalculatorTest.java` файлд JUnit 5 ашиглан бичсэн.



Тестүүдэд дараах JUnit 5 боломжуудыг ашигласан:



\- `@Test`

\- `@DisplayName`

\- `@ParameterizedTest`

\- `@CsvSource`

\- `assertEquals`

\- `assertThrows`



Тестүүдийг аль болох Arrange, Act, Assert бүтэцтэй зохион байгуулсан.



\---



\## 5. Boundary Value Testing



`letterGrade()` method-ийн зааг утгуудыг шалгахын тулд дараах утгуудыг ашигласан:



| Оролтын оноо | Хүлээгдэж буй дүн |

|---:|:---|

| 100 | A |

| 90 | A |

| 89.99 | B |

| 80 | B |

| 79.99 | C |

| 70 | C |

| 69.99 | D |

| 60 | D |

| 59.99 | F |

| 0 | F |



Эдгээр тест нь дүн хооронд шилжих зааг бүр дээр нөхцөл зөв ажиллаж байгаа эсэхийг шалгана.



Жишээлбэл, 90 оноо нь A байх ёстой бол 89.99 оноо B байх ёстой.



\---



\## 6. Exception тестүүд



Буруу оролтыг систем зөв илрүүлж байгаа эсэхийг `assertThrows` ашиглан шалгасан.



Шалгасан тохиолдлуудын жишээ:



\- 100-аас их нийт оноо

\- Сөрөг нийт оноо

\- Лабораторийн оноо 40-өөс их

\- Шалгалтын оноо сөрөг



Эдгээр тохиолдолд `IllegalArgumentException` үүсэх ёстой.



\---



\## 7. Parameterized Tests



\### letterGrade parameterized test



`@ParameterizedTest` болон `@CsvSource` ашиглан олон boundary value-г нэг тестийн логикоор шалгасан.



Тухайлбал:



```text

100 -> A

90 -> A

89.99 -> B

80 -> B

79.99 -> C

70 -> C

69.99 -> D

60 -> D

59.99 -> F

0 -> F

```



\### totalScore parameterized test



`totalScore()` method-ийг мөн олон оролтын багцаар шалгасан.



Жишээ:



```text

10, 40, 10, 10, 30 -> 100

5, 20, 5, 5, 15 -> 50

0, 0, 0, 0, 0 -> 0

8, 30, 8, 9, 25 -> 80

```



Ингэснээр ижил тестийн логикийг олон dataset дээр давтан ашиглах боломжтой болсон.



\---



\## 8. Энгийн тестийн үр дүн



Тестүүдийг дараах командаар ажиллуулсан:



```powershell

mvn test

```



Бодит үр дүн:



```text

Tests run: 25, Failures: 0, Errors: 0, Skipped: 0



BUILD SUCCESS

```



\### Үр дүнгийн хүснэгт



| Үзүүлэлт | Утга |

|---|---:|

| Нийт ажилласан тест | 25 |

| Failures | 0 |

| Errors | 0 |

| Skipped | 0 |

| Build | SUCCESS |



Ингэснээр хэвийн production code дээр бүх \*\*25 тест амжилттай PASS\*\* болсон.



Бүтэн Maven test output:



```text

results/mvn-test.txt

```



\---



\## 9. Mutation Test



Тестүүд бодит алдааг илрүүлж чадах эсэхийг шалгахын тулд production code-д зориудаар жижиг mutation хийсэн.



\### Анхны зөв нөхцөл



```java

if (score >= 90) {

&#x20;   return "A";

}

```



\### Зориуд өөрчилсөн нөхцөл



```java

if (score > 90) {

&#x20;   return "A";

}

```



Энэхүү өөрчлөлтөөр яг 90 оноо A биш B дүн авах алдаа үүснэ.



\---



\## 10. Mutation Test-ийн үр дүн



Mutation хийсний дараа:



```powershell

mvn test

```



ажиллуулахад дараах бодит үр дүн гарсан:



```text

Tests run: 25, Failures: 2, Errors: 0, Skipped: 0



BUILD FAILURE

```



PowerShell exit code:



```text

1

```



\### Алдааг илрүүлсэн тестүүд



```text

GradeCalculatorTest.score90ShouldReturnA



GradeCalculatorTest.letterGradeBoundaryValues

```



Хоёр тест дээр:



```text

expected: <A> but was: <B>

```



гэсэн алдаа гарсан.



\### Mutation үр дүн



| Үзүүлэлт | Утга |

|---|---:|

| Нийт ажилласан тест | 25 |

| Failures | 2 |

| Errors | 0 |

| Skipped | 0 |

| Build | FAILURE |

| Exit code | 1 |



Mutation тестийн бүтэн output:



```text

results/mvn-test-mutant.txt

```



\---



\## 11. Mutation-ийн тайлбар



Mutation тестээр `score >= 90` нөхцөлийг `score > 90` болгон зориуд өөрчилсөн.



Энэ өөрчлөлт нь маш жижиг харагдавч 90 гэсэн boundary value дээр системийн зан төлөвийг өөрчилсөн. Зөв код дээр 90 оноо A дүн авах ёстой байсан бол mutation хийсэн код дээр B дүн авч эхэлсэн.



`score90ShouldReturnA` тест яг энэ boundary утгыг шалгаж байсан учир алдааг шууд илрүүлсэн.



Мөн parameterized boundary test дотор 90 гэсэн утга байсан тул `letterGradeBoundaryValues` тест мөн FAIL болсон.



Иймээс boundary value testing нь зөвхөн ердийн утгуудыг шалгахаас илүү жижиг нөхцөлийн алдааг илрүүлэхэд үр дүнтэй болох нь харагдсан.



Mutation туршилтын дараа production code-ийг анхны:



```java

score >= 90

```



нөхцөлд буцаан оруулсан.



\---



\## 12. Эцсийн шалгалт



Mutation-ийг буцаан зассаны дараа тестүүдийг дахин ажиллуулсан.



Эцсийн үр дүн:



```text

Tests run: 25, Failures: 0, Errors: 0, Skipped: 0



BUILD SUCCESS

```



Ингэснээр repository-д хадгалагдаж байгаа production code зөв төлөвтэй бөгөөд бүх тест PASS болж байгааг баталгаажуулсан.



\---



\## 13. Дүгнэлт



Энэхүү лабораторийн ажлаар JUnit 5 ашиглан Java програмд нэгжийн тест бичиж, тестийн чанарыг практик байдлаар шалгалаа. `GradeCalculator` классын `letterGrade()` болон `totalScore()` method-үүдэд хэвийн болон алдаатай оролтын тестүүд бичсэн. Үсгэн дүнгийн шилжилтийн 90, 80, 70, 60 зэрэг зааг утгуудыг boundary value testing ашиглан тусгайлан шалгасан. Мөн `@ParameterizedTest` болон `@CsvSource` ашигласнаар олон төрлийн оролтыг давтагдсан кодгүйгээр шалгаж чадсан. Буруу оролтууд дээр `assertThrows` ашиглан exception зөв үүсэж байгаа эсэхийг шалгасан. Хэвийн production code дээр нийт 25 тест ажиллаж, бүх тест амжилттай PASS болсон. Дараа нь `>= 90` нөхцөлийг `> 90` болгон зориуд mutation хийхэд 90 онооны boundary дээр алдаа үүссэн. Уг алдааг хоёр тест амжилттай илрүүлж, Maven build FAILURE болсон. Энэ нь сайн нэгжийн тест зөвхөн зөв код ажиллаж байгааг батлах биш, харин зориуд оруулсан жижиг алдааг илрүүлэх чадвартай байх ёстойг харууллаа. Лабораторийн ажлын үр дүнд boundary testing, parameterized testing, exception testing болон mutation testing-ийн ач холбогдлыг бодит жишээн дээр ойлголоо.



\---



\## 14. Репозиторийн гол файлууд



```text

pom.xml

README.md

.gitignore



src/main/java/GradeCalculator.java

src/test/java/GradeCalculatorTest.java



results/mvn-test.txt

results/mvn-test-mutant.txt

```



`target/` хавтас Maven-ийн build output учраас `.gitignore` файлд орсон бөгөөд repository-д хадгалагдахгүй.

