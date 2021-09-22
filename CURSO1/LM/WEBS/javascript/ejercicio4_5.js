function aleatorio() {
    var n;
    n = Math.floor(Math.random() * 3);
    if (n == 0) window.location = 'https://outlook.live.com/owa/';
    if (n == 1) window.location = 'https://www.google.com/intl/es/gmail/about/#';
    if (n == 2) window.location = 'https://mail.yahoo.com/?.intl=es&.lang=es-ES&.partner=none&.src=fp';
}