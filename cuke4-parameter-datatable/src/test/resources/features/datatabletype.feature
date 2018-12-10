Feature: DataTable Conversion for Cucumber-JVM 4

  Scenario: No.1 DataTable scenario List<List<String>>
    Given the list string lecture details are
      | Jane | 40 | Assistant |
      | Doe  | 30 | Associate |

  Scenario: No.2 DataTable scenario primitive List<LecturePrimitive>
    Given the list primitive lecture details are
      | profName | size | profLevel |
      | Jane     |   40 | ASSISTANT |
      | Doe      |   30 | ASSOCIATE |

  Scenario: No.3 DataTable scenario primitive & enum List<LecturePrimitiveEnum>
    Given the list primitive enum lecture details are
      | profName | size | profLevel |
      | Jane     |   40 | ASSISTANT |
      | Doe      |   30 | ASSOCIATE |

  Scenario: No.4 DataTable scenario primitive & object & enum List<LectureSimple>
    Given the list simple lecture object details are
      | profName | size | profLevel |
      | Jane     |   40 | ASSISTANT |
      | Doe      |   30 | ASSOCIATE |

  Scenario: No.5 DataTable scenario List<Lecture>
    Given the list lecture details are
      | profName | topic         | size | frequency | rooms     |
      | Jack     | A1:Topic One  |   40 |         3 | 101A,302C |
      | Daniels  | B5:Topic Five |   30 |         2 | 220E,419D |

  Scenario: No.6 DataTable scenario List<Lecture>
    Given switch the list lecture details are
      | profName  | Jack         | Daniels       |
      | topic     | A1:Topic One | B5:Topic Five |
      | size      |           40 |            30 |
      | frequency |            3 |             2 |
      | rooms     | 101A,302C    | 220E,419D     |

  Scenario: No.7 DataTable scenario List<LectureLite>
    Given the list no header lecture details are
      | John Doe | A1:Topic One  | 40 | 3 | 101A,302C |
      | Jane Doe | B5:Topic Five | 30 | 2 | 220E,419D |

  Scenario: No.8 DataTable scenario Map<String,String>
    Given the map primitive key value
      | Jane | Assistant |
      | John | Associate |

  Scenario: No.9 DataTable scenario Map<Professor,ProfLevels>
    Given the map object key value
      | Jane | ASSISTANT |
      | John | ASSOCIATE |

  Scenario: No.10 DataTable scenario Map<String, Lecture>
    Given the map primitive key lecture details are
      |   | profName | topic         | size | frequency | rooms     |
      | 1 | John Doe | A1:Topic One  |   40 |         3 | 101A,302C |
      | 2 | Jane Doe | B5:Topic Five |   30 |         2 | 220E,419D |

  Scenario: No.11 DataTable scenario Map<Lectureid, Lecture>
    Given the map lecture details are
      |   | profName | topic         | size | frequency | rooms     |
      | 1 | John Doe | A1:Topic One  |   40 |         3 | 101A,302C |
      | 2 | Jane Doe | B5:Topic Five |   30 |         2 | 220E,419D |

  Scenario: No.12 DataTable scenario Map<Lectureid, Lecture>
    Given switch the map lecture details are
      |           |            1 |             2 |
      | profName  | John Doe     | Jane Doe      |
      | topic     | A1:Topic One | B5:Topic Five |
      | size      |           40 |            30 |
      | frequency |            3 |             2 |
      | rooms     | 101A,302C    | 220E,419D     |

  Scenario: No.13 DataTable scenario Lectures
    Given all lectures details
      | profName | topic          | size | frequency | rooms     |
      | John     | A1:Topic One   |   40 |         3 | 101A,302C |
      | Jane     | Z9:Topic Six   |   30 |         2 | 220E,419D |
      | Patrick  | E5:Topic Two   |   60 |         1 | 901B,732C |
      | Melrose  | M6:Topic Seven |   20 |         2 | 444E,909A |