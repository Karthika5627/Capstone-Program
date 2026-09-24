function login() {

    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    if (email == "admin@gmail.com" && password == "admin123") {

        window.location.href = "admin-dashboard.html";

    }

    else if (email == "user@gmail.com" && password == "user123") {

        window.location.href = "patient-dashboard.html";

    }

    else {

        alert("Invalid Email or Password");

    }
}


function uploadReport() {

    alert("Report uploaded successfully!");

}


function logout() {

    window.location.href = "login.html";

}


function updateProfile() {

    alert("Profile updated successfully!");

}


// ADD NEW TEST

// ADD NEW TEST
function addTest() {

    let name = document.getElementById("testName").value;
    let category = document.getElementById("testCategory").value;
    let price = document.getElementById("testPrice").value;

    if (name == "" || category == "" || price == "") {

        alert("Please fill all fields");
        return;

    }

    let table = document.getElementById("testTable");

    // Calculate ID before adding the new row
    let testId = table.rows.length + 100;

    let row = table.insertRow();

    row.innerHTML = `
        <td>${testId}</td>
        <td>${name}</td>
        <td>${category}</td>
        <td>${price}</td>
        <td>
            <button onclick="editTest(this)">Edit</button>
            <button onclick="deleteTest(this)">Delete</button>
            <a href="book-test.html">
                <button type="button">Book Now</button>
            </a>
        </td>
    `;

    document.getElementById("testName").value = "";
    document.getElementById("testCategory").value = "";
    document.getElementById("testPrice").value = "";

    alert("Test added successfully!");
}


// EDIT TEST
function editTest(button) {

    let row = button.parentElement.parentElement;

    let name = prompt("Enter Test Name:", row.cells[1].innerText);

    let category = prompt("Enter Category:", row.cells[2].innerText);

    let price = prompt("Enter Price:", row.cells[3].innerText);

    if (name != null && category != null && price != null) {

        row.cells[1].innerText = name;
        row.cells[2].innerText = category;
        row.cells[3].innerText = price;

    }

}


// DELETE TEST
function deleteTest(button) {

    if (confirm("Are you sure you want to delete this test?")) {

        button.parentElement.parentElement.remove();

    }

}