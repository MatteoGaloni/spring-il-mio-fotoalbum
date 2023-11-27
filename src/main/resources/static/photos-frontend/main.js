const apiUrl = "http://localhost:8080/api/photos";
const root = document.getElementById("root");
const searchBtn = document.getElementById("searchBtn");
const searchInput = document.getElementById("searchInput");


//Get Photos Function//

const getPhotos = async (value = null) => {
    try {
        let apiUrlParam = apiUrl
        if (value) {
            apiUrlParam += "?search=" + value;
        }
        const response = await axios.get(apiUrlParam);
        console.log("response ok!", response)
        createPhotoContainer(response.data);
    } catch (error) {
        console.log(error);
    }
}
getPhotos();


//Create Photos Container//
const createPhotoContainer = (data) => {
    let content;
    if (data.content.length > 0) {
        content = '<div class="row gy-2">';
        data.content.forEach((photo) => {
            content += '<div class="col-md-6 col-lg-3">';
            content += '<div class="card" style="width: 18rem;">';
            content += `<img src="${photo.url}" class="card-img-top" alt="${photo.title}">`;
            content += '<div class="card-body">';
            content += `<h5 class="card-title">${photo.title}</h5>`;
            content += `<p class="card-text">${photo.description}</p>`;
            content += `<p class="card-text">${photo.userEmail}</p>`;
            content += `<p class="card-text">${photo.user.firstName + " " + photo.user.lastName}</p>`;
            content += '</div></div></div>';
        });
        content += '</div>';
    }

    root.innerHTML = content;

}

//Search by filter function

searchBtn.addEventListener("click", (event) => {
    event.preventDefault();
    const value = searchInput.value.trim();
    getPhotos(value);
})


