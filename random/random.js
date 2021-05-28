
function ut(){
    return new Date().getTime() % 100;
}

var seed=46;
function random99(){
    seed = seed + seed + ut() + 7;
    seed = seed * seed * ut() * 3;
    seed = seed % 100
    return seed;
}

function random(min,max){
    var r =random99();
    return min + (r * (max-min)/100);
}

for(let i=0 ; i<50 ; i++){
    console.log(random(25,75));
}