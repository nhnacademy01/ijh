const form = document.createElement("form");
form.setAttribute("charset", "UTF-8");
form.setAttribute("method", "Post");
form.setAttribute("action", "https://httpbin.org/post");

const hiddenField1 = document.createElement("input");
hiddenField1.setAttribute("type", "hidden");
hiddenField1.setAttribute("name", "myName");
hiddenField1.setAttribute("value", "Marco");
form.appendChild(hiddenField1);

const hiddenField2 = document.createElement("input");
hiddenField2.setAttribute("type", "hidden");
hiddenField2.setAttribute("name", "myEmail");
hiddenField2.setAttribute("value", "marco@nhnacademy.com");
form.appendChild(hiddenField2);

document.body.appendChild(form);
form.submit();