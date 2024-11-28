document.querySelectorAll('.drive').forEach(drive => {
    const images = drive.querySelectorAll('.drive-images img');
    const prevBtn = drive.querySelector('.prev-btn');
    const nextBtn = drive.querySelector('.next-btn');
    let currentIndex = 0;

    function showImage(index) {
        images.forEach((img, i) => {
            img.style.display = i === index ? 'block' : 'none';
        });
    }

    // Show the first image initially
    showImage(currentIndex);

    // Event listeners for manual navigation
    prevBtn.addEventListener('click', () => {
        currentIndex = (currentIndex - 1 + images.length) % images.length;
        showImage(currentIndex);
    });

    nextBtn.addEventListener('click', () => {
        currentIndex = (currentIndex + 1) % images.length;
        showImage(currentIndex);
    });

    // Auto-slide every 3 seconds
    setInterval(() => {
        currentIndex = (currentIndex + 1) % images.length;
        showImage(currentIndex);
    }, 3000);
});


// faq.js

// Toggle FAQ answer visibility
function toggleAnswer(index) {
    const faqItems = document.querySelectorAll('.faq-item');
    const targetItem = faqItems[index];

    // Toggle the open class to show/hide the answer
    targetItem.classList.toggle('open');
}


document.getElementById('eligibility-form').addEventListener('submit', function (e) {
    e.preventDefault(); // Prevent the form from submitting and refreshing the page
    console.log("Form submitted!");

    // Hide the form
    document.getElementById('eligibility-form').style.display = 'none';

    // Get input values
    const age = parseInt(document.getElementById('age').value);
    const weight = parseInt(document.getElementById('weight').value);
    const health = document.getElementById('health').value;
    const pregnant = document.getElementById('pregnant').value;
    const heart_condition = document.getElementById('heart_condition').value;
    const blood_pressure = document.getElementById('blood_pressure').value;
    const medications = document.getElementById('medications').value;
    const tattoo = document.getElementById('tattoo').value;
    

    let message = '';
    let details = '';

    // Eligibility check
    if (age < 18 || age > 60) {
        message = 'You are not eligible to donate blood.';
        details = 'You must be between 18 and 60 years of age to donate blood.';
    } else if (weight < 45) {
        message = 'You are not eligible to donate blood.';
        details = 'You must weigh at least 45 kg to donate blood.';
    } else if (health === 'no') {
        message = 'You are not eligible to donate blood.';
        details = 'You have a chronic condition, so you are not eligible to donate blood.';
    } else if (pregnant === 'yes') {
        message = 'You are not eligible to donate blood.';
        details = 'As you mentioned you are pregnant';
    } else if (heart_condition === 'yes') {
        message = 'You are not eligible to donate blood.';
        details = 'As you mentioned you have a heart conditions.';
    }  else if (medications === 'yes') {
        message = 'You are not eligible to donate blood.';
        details = 'As you mentioned you are taking medications.';
    }  else if (tattoo === 'yes') {
        message = 'You are not eligible to donate blood.';
        details = 'Peaple had tattoo or body piercing within 6 months are not eligible to donate blood .';
    }  else if (blood_pressure === 'yes') {
        message = 'You are not eligible to donate blood.';
        details = 'As you mentioned you have high/low Blood Pressure problem.';
    }  else {
        message = 'You are eligible to donate blood!';
        details = 'As per your answers, you meet the eligibility requirements for donating blood. Thank you for your willingness to help!';
    }

    // Show the result
    const resultContainer = document.getElementById('eligibility-result');
    const resultMessage = document.getElementById('result-message');
    const resultDetails = document.getElementById('result-details');

    resultMessage.innerText = message;
    resultDetails.innerText = details;

    // Show the result container after form submission
    resultContainer.style.display = 'block';
});
