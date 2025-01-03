document.getElementById("bookingForm").addEventListener("submit", function (event) {
  event.preventDefault();

  const destination = document.getElementById("destination").value;
  const date = document.getElementById("date").value;
  const travelers = document.getElementById("travelers").value;

  if (destination && date && travelers) {
    const confirmationMessage = `You have successfully booked a trip to ${destination.toUpperCase()} on ${date} for ${travelers} traveler(s).`;
    document.getElementById("confirmationMessage").textContent = confirmationMessage;

    document.getElementById("bookingForm").classList.add("hidden");
    document.getElementById("confirmation").classList.remove("hidden");
  }
});

function resetForm() {
  document.getElementById("bookingForm").reset();
  document.getElementById("confirmation").classList.add("hidden");
  document.getElementById("bookingForm").classList.remove("hidden");
}