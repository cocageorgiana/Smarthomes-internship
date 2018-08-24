export function getUser(username) {
  return new Promise((resolve, reject) => {
    return fetch(`http://localhost:5555/api/users?username=${username}`)
      .then(function (response) {
        return response.json();
      })
      .then(function (response) {
        resolve(response);
      })
  })
}
