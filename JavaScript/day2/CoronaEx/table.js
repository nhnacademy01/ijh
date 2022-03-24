function OnLoadTable() {
    const hTbody = document.getElementById('htmlTbody');

    for (let i = 0; i < itemList.length; i++) {
        const newRow0 = hTbody.insertRow();
        newRow0.insertCell();
        newRow0.insertCell();
        newRow0.insertCell();
        newRow0.insertCell();

        hTbody.rows[i].cells[0].innerHTML = itemList[i].createDt
        hTbody.rows[i].cells[1].innerHTML = itemList[i].decideCnt
        hTbody.rows[i].cells[2].innerHTML = itemList[i].deathCnt
        hTbody.rows[i].cells[3].innerHTML = itemList[i].updateDt
    }
}