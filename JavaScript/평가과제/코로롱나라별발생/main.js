const list_element = document.getElementById('htmlTbody');
const pagination_element = document.getElementById('pagination');

let current_page = 1; // 현재 페이지number
let rows = 6;         // 한 페이지당 보여줄 item 갯수

let serviceKey = "OS4U4zQ8fMWfUZpyrjOX85mRqdFBCBkLk7pqagaoxcG1Bm9%2B73ZpV6LgRYjqCPCDF%2FKEC5BHbZ272zU%2BUwOTWQ%3D%3D";

var xhr = new XMLHttpRequest();
var url = 'http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19NatInfStateJson'; /*URL*/
var queryParams = '?' + encodeURIComponent('serviceKey') + '=' + serviceKey; /*Service Key*/
queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('10'); /**/
queryParams += '&' + encodeURIComponent('startCreateDt') + '=' + encodeURIComponent('20220325'); /**/
queryParams += '&' + encodeURIComponent('endCreateDt') + '=' + encodeURIComponent('20220325'); /**/
xhr.open('GET', url + queryParams);

let itemList = [];

let afreeca = [];
let oseania = [];
let europe = [];
let middleEast = [];
let asia = [];
let america = [];
let other = [];

let chartData = []
let testData = [
    ['Others', 600],
    ['France', 600],
    ['kr', 600],
]

fetch(url + queryParams)
    .then(response => response.text())
    .then(data => new window.DOMParser().parseFromString(data, "text/xml"))
    .then(data => data.getElementsByTagName("item"))
    .then(function (items) {
        for (let i = 0; i < items.length; i++) {
            let areaNm = items[i].getElementsByTagName("areaNm")[0].innerHTML; // 대륙
            let nationNmEn = items[i].getElementsByTagName("nationNmEn")[0].innerHTML; // 대륙
            let nationNm = items[i].getElementsByTagName("nationNm")[0].innerHTML; // 지역
            let natDefCnt = items[i].getElementsByTagName("natDefCnt")[0].innerHTML; // 확진자수
            let natDeathRate = items[i].getElementsByTagName("natDefCnt")[0].innerHTML; // 사망률

            let item = {
                areaNm,
                nationNmEn,
                nationNm,
                natDefCnt,
                natDeathRate,
            }
            itemList.push(item);
        }
        DisplayList(itemList, list_element, rows, current_page);
        setupPagination(itemList, pagination_element, rows);
        SetAreaName();
        MapStart();
    }
    ).catch((error) => { console.log(error) });


// 한페이지당 보여질 itemList
function DisplayList(items, wrapper, rows_per_page, page) {
    wrapper.innerHTML = "";
    page--;

    let start = rows_per_page * page;                     // 페이지 * 보여줄갯수 ex) 현재2번째 페이지이고, 5개씩 보여준다면 10부터 시작.
    let end = start + rows_per_page;
    let paginatedItems = items.slice(start, end);         // 잘라서 작업이 끝난 item만 보여주면 됌.(cuurent_page에 실제로 보여줘야할 item들)

    for (let i = 0; i < paginatedItems.length; i++) {
        let nationNm = paginatedItems[i].nationNm;
        let natDefCnt = paginatedItems[i].natDefCnt;
        let incDec = paginatedItems[i].incDec + "▲";
        let natDeathRate = paginatedItems[i].natDeathRate;

        const newRow0 = wrapper.insertRow();

        newRow0.insertCell();
        newRow0.insertCell();
        newRow0.insertCell();
        newRow0.insertCell();

        wrapper.rows[i].cells[0].innerHTML = nationNm
        wrapper.rows[i].cells[1].innerHTML = natDefCnt
        wrapper.rows[i].cells[2].innerHTML = incDec
        wrapper.rows[i].cells[3].innerHTML = natDeathRate

        wrapper.rows[i].cells[0].setAttribute('onclick', `window.open('http://www.naver.com', '', '')`)
        wrapper.rows[i].cells[0].setAttribute('style', 'cursor:pointer')
    }
}

// 표시해줄 페이지갯수, 버튼갯수 추가
function setupPagination(items, wrapper, rows_per_page) {
    wrapper.innerHTML = "";

    let page_count = Math.ceil(items.length / rows_per_page); // 페이지 갯수

    // 페이지 갯수만큼 버튼추가
    for (let i = 1; i < page_count + 1; i++) {
        let btn = PagenationButton(i, items);
        wrapper.appendChild(btn);
    }
}

// 버튼관련 동작함수
function PagenationButton(page, items) {
    let button = document.createElement('button')
    button.innerText = page;

    // 현재페이지와 버튼숫자가 같으면 버튼색깔 active하게 바꿔줌
    if (current_page == page) button.classList.add('active');

    button.addEventListener('click', function () {
        current_page = page;
        DisplayList(items, list_element, rows, current_page);

        let current_btn = document.querySelector('.pagenumbers button.active');
        current_btn.classList.remove('active'); // 기존 active 지워주고

        button.classList.add('active');         // 현재버튼에 active class 추가
    })

    return button;
}

// 각 지역별 나라배열 설정
function SetAreaName() {

    for (let i = 0; i < itemList.length; i++) {
        switch (itemList[i].areaNm) {
            case '아프리카':
                afreeca.push(itemList[i])
                break;
            case '유럽':
                europe.push(itemList[i])
                break;
            case '오세아니아':
                oseania.push(itemList[i])
                break;
            case '중동':
                middleEast.push(itemList[i])
                break;
            case '아메리카':
                america.push(itemList[i])
                break;
            case '아시아':
                asia.push(itemList[i])
                break;
            default:
                other.push(itemList[i])
                break;
        }
    }
}

// selectBox 이벤트리스너
let selectBox = document.querySelector('.area');
selectBox.onchange = function () {
    switch (selectBox.value) {
        case '아시아':
            DisplayList(asia, list_element, rows, current_page);
            setupPagination(asia, pagination_element, rows);
            break;
        case '아프리카':
            DisplayList(afreeca, list_element, rows, current_page);
            setupPagination(afreeca, pagination_element, rows);
            break;
        case '유럽':
            DisplayList(europe, list_element, rows, current_page);
            setupPagination(europe, pagination_element, rows);
            break;
        case '오세아니아':
            DisplayList(oseania, list_element, rows, current_page);
            setupPagination(oseania, pagination_element, rows);
            break;
        case '중동':
            DisplayList(middleEast, list_element, rows, current_page);
            setupPagination(middleEast, pagination_element, rows);
            break;
        case '아메리카':
            DisplayList(america, list_element, rows, current_page);
            setupPagination(america, pagination_element, rows);
            break;
        case '기타':
            DisplayList(other, list_element, rows, current_page);
            setupPagination(other, pagination_element, rows);
            break;
        default:
            DisplayList(itemList, list_element, rows, current_page);
            setupPagination(itemList, pagination_element, rows);
            break;
    }
}

// 지도
function MapStart() {
    for (let i = 0; i < itemList.length; i++) {
        chartData.push([itemList[i].nationNmEn, Number(itemList[i].natDefCnt)])
    }
    // 지도
    google.charts.load('current', {
        'packages': ['geochart'],
    });
    google.charts.setOnLoadCallback(drawRegionsMap);
}

function drawRegionsMap() {
    let data = new google.visualization.DataTable();

    // Declare columns
    data.addColumn('string', '국가')
    data.addColumn('number', '확진자 수')

    data.addRows(chartData)

    let options = {};
    let chart = new google.visualization.GeoChart(document.getElementById('regions_div'));
    chart.draw(data, options);
}