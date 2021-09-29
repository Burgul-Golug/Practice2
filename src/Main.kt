fun main(){
    var persons = listOf(Student("Владислав Отряскин", 2000, 5.0),
        Student("Александр Черняев", 2002, 4.0),
        Student("Артур Норматов", 2001, 3.25),
        Student("Мария Кузнецова", 2003, 4.9),
        Student("Егор Мальгин", 2003, 4.7, true),
        Lecturer("Наталья Станиславовна", 1976, "Кандидат экономических наук", 2001),
        Lecturer("Оксана Александровна", 1972, "Кандидат технических наук", 2015),
        Lecturer("Анна Александровна", 1988, "Кандидат технических наук", 2006),
        Lecturer("Анатолий Николавевич", 1973, "Кандидат физико-математических наук", 1998),
        Lecturer("Наталья Михайловна", 1975, "Доктор филологических наук", 2010))

    println("Вызов метода sortByAge()")
    persons.sortByAge().forEach {println("Имя: ${it.name}; Возраст: ${it.age}")}

    var personsST =mutableListOf<Student>()
    persons.forEach { if (it is Student) personsST.add(it) }

    println("\nВызов метода sortByNameStudents()")
    personsST.sortByNameStudents().forEach {println("Имя: ${it.name}; Возраст: ${it.age}")}

    println("\nВызов метода sortByAverageGrade(true)")
    personsST.sortByAverageGrade(true).forEach {println("Имя: ${it.name}; Средняя оценка: ${it.averageGrade}")}

    println("\nВызов метода sortByAverageGrade(false)")
    personsST.sortByAverageGrade(false).forEach {println("Имя: ${it.name}; Средняя оценка: ${it.averageGrade}")}

}

fun List<Person>.sortByAge(): List<Person>
{
    return this.sortedByDescending{it.age}
}

fun List<Student>.sortByNameStudents(): List<Student>
{
    return this.sortedByDescending{it.name}
}

fun List<Student>.sortByAverageGrade(exceptExtramural: Boolean): List<Student>{
    if (exceptExtramural == true)
        return this.filter{!it.extramural}.sortedByDescending {it.averageGrade}
    else
        return this.sortedByDescending {it.averageGrade}
}