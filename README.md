# Лабораторна робота 2

## Функціональність програми:
**Вдосконалити бібліотеку з попередньої програми**

**Програма повинна вміти:**
- Додавати предмети (книги, DVD) до бібліотеки
- Видаляти предмети з бібліотеки
- Реєструвати читача
- Видавати предмет читачеві
- Повертати предмет у бібліотеку
- Показувати список доступних предметів
- Показувати список взятих предметів та їхніх читачів

## Опис роботи:

1. Робив покроково за рекомендаціями в лабораторній
2. Створив клас `Item` з заданими атрибутами та методи
3. Створив два класа `Book` та `DVD` з прив'язкою до класу `Item`, де добавив потрібні атрибути відповідно
4. Створив клас `Patron` з заданими атрибутами для читача та його взяті предмети
5. Створив інтерфейс `IManageable` з методами, щоб забезпечити управління предметами
6. Змінив клас `Library` в якому реалізував методи з інтерфейсу `IManageable` та реалізував інші потрібні методи
7. Вдосконалив клас `Main` добавивши нові опції для вводу користувачем
8. Зробив тести для перевірки роботи з предметами в бібліотеці/читача

# Висновок:
Створював тести до написаної програми