function deleteSomething(id) {
    fetch('/users/delete/' + id,  {
      method: 'DELETE'
    })
    .then(() => {
      window.location.reload();
  })
  }
  


