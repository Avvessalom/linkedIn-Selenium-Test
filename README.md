Прецедент             | Поиск по компаниям
:-----:               | :---- 
ID                    | 1
Краткое описание      | Пользователь использует поиск
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | Пользователь авторизован
Основной поток        |  Пользователь открывает поле поиска и выбивает туда название компании

Прецедент             | Публикация нового поста
:-----:               | :---- 
ID                    | 2
Краткое описание      | Пользователь публикует новый пост в своей ленте
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | Пользователь авторизован
Основной поток        |  Пользователь нажимает на поле создания нового поста, оформляет его (пишет какой-либо текст, добавляет хеш-теги) а затем публикует

Прецедент             | Поиск вакансии
:-----:               | :---- 
ID                    | 3
Краткое описание      | Пользователь ищет вакасию
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | Пользователь авторизован
Основной поток        |  Пользователь открывает поле поиска и выбивает туда название интересуемой его вакансии

Прецедент             | Создание нового события
:-----:               | :---- 
ID                    | 4
Краткое описание      | Пользователь создает новое событие
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | Пользователь авторизован
Основной поток        |  Пользователь нажимает на кнопку создания нового события, настраивает необходимые параметры (название события, место и дата проведения, список приглашенных), а затем публикует его

Прецедент             | Удаление ранее созданного события
:-----:               | :---- 
ID                    | 5
Краткое описание      | Пользователь удаляет созданное ранее событие
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | Пользователь авторизован, пользователь является организатором этого события
Основной поток        |  Пользователь в списке событий, на которые он зарегистрирован, выбирает нужное ему мероприятие и удаляет его

Прецедент             | Авторизация
:-----:               | :---- 
ID                    | 6
Краткое описание      | Пользователь авторизуется в ранее созданный им аккаунт
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | нет
Основной поток        | Пользователь вводит логин и пароль в форме авторизации. Если авторизация прошла успешно, то он попадает на главную страницу.
Альтернативный поток | При вводе несуществующих логина или пароля, а также неправильных данных пользователь получит ошибку

Прецедент             | Поиск работы гостем
:-----:               | :---- 
ID                    | 7
Краткое описание      | Гость ищет вакансии
Главные акторы        | Гость
Второстепенные акторы | нет
Предусловия           | нет
Основной поток        | Гость открывает поле поиска и выбивает туда название интересуемой его вакансии

Прецедент             | Поиск онлайн-курсов гостем
:-----:               | :---- 
ID                    | 8
Краткое описание      | Гость ищет онлайн-курсы
Главные акторы        | Гость
Второстепенные акторы | нет
Предусловия           | нет
Основной поток        | Гость нажимает на кнопку "онлайн-курсы" и осуществляет поиск по введенному названию

Прецедент             | Пользователь пишет сообщение другому пользователю
:-----:               | :---- 
ID                    | 9
Краткое описание      | Пользователь пишет сообщение другому пользователю
Главные акторы        | Пользователь1
Второстепенные акторы | Пользователь2
Предусловия           | Пользователь авторизован
Основной поток        | Пользователь переходит на страницу "Сообщения", выбирает адресата или адресатов и пишет новое сообщение

Прецедент             | Просмотр уведомления
:-----:               | :---- 
ID                    | 10
Краткое описание      | Пользователь просматривает список уведомлений
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | Пользователь авторизован
Основной поток        | Пользователь переходит на страницу "Уведомления" и пролистывает список уведомлений. Выбрав какое-то уведомление пользователь кликает на него и переходит на страницу с содержимым

Прецедент             | Просмотр профиля пользователя
:-----:               | :---- 
ID                    | 11
Краткое описание      | Пользователь просматривает профиль
Главные акторы        | Пользователь или гость
Второстепенные акторы | нет
Предусловия           | нет
Основной поток        | Пользователь переходит на профиль другого пользователя и просматривает профиль

Прецедент             | Добавление места учебы в профиле
:-----:               | :---- 
ID                    | 12
Краткое описание      | Пользователь добавляет место учебы в профиль
Главные акторы        | Пользователь
Второстепенные акторы | нет
Предусловия           | пользователь авторизован
Основной поток        | Пользователь кликает на кнопку "добавить место учебы", заполняет необоходимую информацию и нажимает сохранить
