function fillTemplate(cardList){
    let template = document.querySelector("#row");

    for(const card of cardList){
        let clone = document.importNode(template.content, true);
    
        newContent= clone.firstElementChild.innerHTML
                    .replace(/{{family_src}}/g, card.imgUrl)
                    .replace(/{{family_name}}/g, card.family)
                    .replace(/{{img_src}}/g, card.imgUrl)
                    .replace(/{{name}}/g, card.name)
                    .replace(/{{description}}/g, card.description)
                    .replace(/{{hp}}/g, card.hp)
                    .replace(/{{energy}}/g, card.energy)
                    .replace(/{{attack}}/g, card.attack)
                    .replace(/{{defense}}/g, card.defense)
                    .replace(/{{price}}/g, card.prix);
        clone.firstElementChild.innerHTML= newContent;
    
        let cardContainer= document.querySelector("#tableContent");
        cardContainer.appendChild(clone);
    }
}

function getCardList(){
    console.log("Tentative de connexion");
    let requestURL = "http://localhost:8081/users/0/cards";
    var parameter = new Map();
    var cardJson = new String();
    cardJson = sendApiRequest(requestURL,"GET",parameter);
}

window.addEventListener("load", (event) => {
    this.getCardList()
});
