function abrir() {
    var n1, n2, s1, s2, config;
    n1 = parseInt(screen.width);
    n2 = parseInt(screen.height)/2;
    s1 = 'width=';
    s2 = ',height=';
    config = s1.concat(n1,s2,n2);
    
    window.open('','',config);
}