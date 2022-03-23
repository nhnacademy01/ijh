const dayOfWeek = ['월','화','수','목','금','토','일'];
let dayCount = 1;
let dayColor = "black";

for (let i = 1; i < 31; i++) {
    // 날짜, 요일 생성
    document.write(`<table border="1"><tr>
    <td style="color:${dayColor}">` + i + `<br>${dayOfWeek[dayCount]}` + '</td>');
    document.write('<td>' + "&nbsp" + '</td>'); // 2번째 공백란

    // 추가, 모두삭제버튼 생성
    document.write('<td>' + 
    `<input type='text' id='textBox${i}'>` + 
    `<button onclick="OnClickAddBtn(${i})">추가</button><br>` + 
    `<button id="list${i}" onclick="OnClickAllDelBtn(this.id)">모두삭제</button>` + '</td>');

    document.write(`<td><ul id='day-list${i}'></ul></td></tr></table>`); // 오른쪽 list

    dayCount++;
    if(dayCount == 5) {
        dayColor = "blue"
    } else if(dayCount == 6) {
        dayColor = "red"
    } else {
        dayColor = "black"
    }

    // 다시 월요일부터
    if(dayCount == 7) {
        dayCount = 0;
    }
}

// 추가버튼
function OnClickAddBtn(lineNumber){
    let textValue = document.getElementById(`textBox${lineNumber}`).value;
    let dayList = document.getElementById(`day-list${lineNumber}`) 

    // lineNumber번째의 ul의 Id를 담아서 list에 버튼객체를 만들어서 생성해준다.
    dayList.innerHTML += `<li><button class="list${lineNumber}" id="listBtn${lineNumber}" onclick="OnClickListBtn(this.id)">${textValue}</button></li>`
}

// 모두삭제버튼
function OnClickAllDelBtn(className){
    let classList = document.getElementsByClassName(className)

    for(var i=classList.length-1; i>=0; i--) {
        classList.item(i).parentElement.remove()
    }
}

// 오른쪽 리스트버튼
function OnClickListBtn(clickedId){
    const listBtnId = document.getElementById(clickedId)
    listBtnId.parentElement.remove();
}

