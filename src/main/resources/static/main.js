

const contactInputs = document.querySelectorAll('.contact-input'); //znajdujemy wszystkie lementy z klasy contact-input

console.log('Dziala')

for(let i = 0; i < contactInputs.length; i++){
    //wewnątrz pętli musimy dostać dostę do lebela, czyli input name itd.
    let currentLabel = contactInputs[i].parentElement.firstElementChild; //uzyskujemy dostęp do pierwszego elementu child
    
    //potrzebujemy dodać nasłuch na zdarzenie focus, czyli najechanie kursorem na pola input

    contactInputs[i].addEventListener('focus', function(){
        currentLabel.classList.add('move-up');
    });

    contactInputs[i].addEventListener('blur', function(){
        if(contactInputs[i].value === '')
        currentLabel.classList.remove('move-up')
    });

}


