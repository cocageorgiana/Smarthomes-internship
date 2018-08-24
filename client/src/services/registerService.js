export function register(formData) {
  return new Promise((resolve, reject) => {
    return fetch('http://localhost:5555/api/register', {
      method: "POST",
      mode: "cors",
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData)
    })
    .then(function(response) {
      return response.json();
    })
    .then(function (response) {
      resolve(response);
    })
  })
}