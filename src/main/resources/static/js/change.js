function deleteSomething(id) {
    fetch('/users/delete/' + id,  {
      method: 'DELETE'
    })
    .then(() => {
      window.location.reload();
  })
  }
  
 // function editSomething(id) {
    //window.location.replace("/users/edit");
    
 // }
 //function editSomething(id) {
  //fetch('/users/view/' + id,  {
    //method: 'GET'
  //})
  
//}

//function drawSomething(id){
  //var javaWidth = "${users.weight}";
  //var javaHeight = "${users.height}";

  //var shape = document.getElementsByClassName(shape)
  //const button = document.getElementById('shape');
  //fetch('/users/view/' + id)
  //{
    //var javaWidth = "${us.weight}";
    //var javaHeight = "${us.height}";
  
    //var shape = document.getElementsByClassName('shape');
    //const button = document.getElementById('shape');
    //shape.style.width = javaWidth + 'px';
    //shape.style.height = javaHeight + 'px';
    //window.location.replace("/users/usersShape");
//};
  
//}