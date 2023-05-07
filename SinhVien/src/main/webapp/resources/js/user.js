/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function deleteUser(endpoint, id) {
    if (confirm("Xoa?") == true) {
        let s = document.getElementById(`spinner${id}`)
        s.style.display = "block";

        fetch(endpoint, {
            method: "delete"
        }).then(res => {
            s.style.display = "none";
            console.info(res);
            if (res.status === 204) {
                alert("Xoa thanh cong");  
                document.getElementById(`user${id}`).style.display="none";
            }
            else
                alert("He thong loi, thu lai sau!");
        });
    }
}