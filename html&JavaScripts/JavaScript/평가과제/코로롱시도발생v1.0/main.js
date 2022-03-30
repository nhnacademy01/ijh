const list_element = document.getElementById('htmlTbody');
const pagination_element = document.getElementById('pagination');

let current_page = 1; // 현재 페이지number
let rows = 6;         // 한 페이지당 보여줄 item 갯수
let cityNumber;       // 얘를 index.html에 넘겨주어야 하는데..

let serviceKey = "OS4U4zQ8fMWfUZpyrjOX85mRqdFBCBkLk7pqagaoxcG1Bm9%2B73ZpV6LgRYjqCPCDF%2FKEC5BHbZ272zU%2BUwOTWQ%3D%3D";

var xhr = new XMLHttpRequest();
var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220326'); /**/
queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220326'); /**/
xhr.open('GET', url + queryParams);

let itemList = [];
fetch(url + queryParams)

    .then(response => response.text())
    .then(data => new window.DOMParser().parseFromString(data, "text/xml"))
    .then(data => data.getElementsByTagName("item"))
    .then(function (items) {
        for (let i = 0; i < items.length; i++) {
            let gubun = items[i].getElementsByTagName("gubun")[0].innerHTML;
            let defCnt = items[i].getElementsByTagName("defCnt")[0].innerHTML;
            let incDec = items[i].getElementsByTagName("incDec")[0].innerHTML;

            let item = {
                gubun,
                defCnt,
                incDec,
            }
            itemList.push(item);
        }
        itemList = itemList.reverse();
        DisplayList(itemList, list_element, rows, current_page);
        setupPagination(itemList, pagination_element, rows);
    }
    ).catch((error) => { console.log(error) });

// 한페이지당 보여질 itemList
function DisplayList (items, wrapper, rows_per_page, page) {
    wrapper.innerHTML ="";
    page--;

    let start = rows_per_page * page;                     // 페이지 * 보여줄갯수 ex) 현재2번째 페이지이고, 5개씩 보여준다면 10부터 시작.
    let end = start + rows_per_page;
    let paginatedItems = items.slice(start, end);         // 잘라서 작업이 끝난 item만 보여주면 됌.(cuurent_page에 실제로 보여줘야할 item들)

    for (let i = 0; i < paginatedItems.length; i++) {
        let item = paginatedItems[i].gubun;
        let item2 = paginatedItems[i].defCnt;
        let item3 = paginatedItems[i].incDec + "▲";

        const newRow0 = wrapper.insertRow();
        newRow0.insertCell();
        newRow0.insertCell();
        newRow0.insertCell();

        wrapper.rows[i].cells[0].innerHTML = item
        wrapper.rows[i].cells[1].innerHTML = item2
        wrapper.rows[i].cells[2].innerHTML = item3

        wrapper.rows[i].cells[0].classList.add('item')
        wrapper.rows[i].cells[1].classList.add('item')
        wrapper.rows[i].cells[2].classList.add('item')

        wrapper.rows[i].cells[0].setAttribute('id', `${i}`)
        wrapper.rows[i].cells[0].setAttribute('onclick', 'OnclickCityName(this)')
        wrapper.rows[i].cells[0].setAttribute('style', 'cursor:pointer')
    }
}

function OnclickCityName(element) {
    window.open('./search.html', '', '')
    cityNumber = element;
}

function setupPagination (items, wrapper, rows_per_page) {
    wrapper.innerHTML = "";

    let page_count = Math.ceil(items.length / rows_per_page); // 페이지 갯수

    // 페이지 갯수만큼 버튼추가
    for (let i = 1; i < page_count + 1; i++) {
        let btn = PagenationButton(i, items);
        wrapper.appendChild(btn);
    }
}

// 버튼관련 동작함수
function PagenationButton (page, items) {
    let button = document.createElement('button')
    button.innerText = page;

    // 현재페이지와 버튼숫자가 같으면 버튼색깔 active하게 바꿔줌
    if (current_page == page) button.classList.add('active');

    button.addEventListener('click', function() {
        current_page = page;
        DisplayList(items, list_element, rows, current_page);

        let current_btn = document.querySelector('.pagenumbers button.active');
        current_btn.classList.remove('active'); // 기존 active 지워주고

        button.classList.add('active');         // 현재버튼에 active class 추가
    })

    return button;
}

