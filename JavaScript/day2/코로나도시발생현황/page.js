const list_items = [
    "Item 1",
    "Item 2",
    "Item 3",
    "Item 4",
    "Item 5",
    "Item 6",
    "Item 7",
    "Item 8",
    "Item 9",
    "Item 10",
    "Item 11",
    "Item 12",
    "Item 13",
    "Item 14",
    "Item 15",
    "Item 16",
    "Item 17",
    "Item 18",
    "Item 19",
    "Item 20",
    "Item 21",
    "Item 22",
];

const list_element = document.getElementById('list');
const pagination_element = document.getElementById('pagination');

let current_page = 1; // 현재 페이지number
let rows = 5;         // 한 페이지당 보여줄 item 갯수

// 한페이지당 보여질 itemList
function DisplayList (items, wrapper, rows_per_page, page) {
    wrapper.innerHTML ="";
    page--;

    let start = rows_per_page * page;                     // 페이지 * 보여줄갯수 ex) 현재2번째 페이지이고, 5개씩 보여준다면 10부터 시작.
    let end = start + rows_per_page;
    let paginatedItems = items.slice(start, end);         // 잘라서 작업이 끝난 item만 보여주면 됌.(cuurent_page에 실제로 보여줘야할 item들)

    for (let i = 0; i < paginatedItems.length; i++) {
        let item = paginatedItems[i];

        let item_element = document.createElement('div'); // div를 하나만듬
        item_element.classList.add('item');               // 만든div를 itemclass에 추가함
        item_element.innerText = item;                    // 만든div에 item을 추가함

        wrapper.appendChild(item_element);                // id가 list인객체의 자식으로 만든div를 추가함
    }
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

DisplayList(list_items, list_element, rows, current_page);
setupPagination(list_items, pagination_element, rows);