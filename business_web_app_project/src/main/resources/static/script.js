document.addEventListener("DOMContentLoaded", function () {
  console.log("JavaScript is working!");

  const mobileNav = document.querySelector(".hamburger");
  let navbar = document.querySelector(".menubar");

  console.log("Mobile Nav Element:", mobileNav);
  console.log("Navbar Element:", navbar);

  const toggleNav = () => {
    navbar = document.querySelector(".menubar"); // re-check the element
    if (navbar) {
      navbar.classList.toggle("active");
      console.log("Toggled navbar");
    } else {
      console.error("Navbar element not found");
    }
    if (mobileNav) {
      mobileNav.classList.toggle("hamburger-active");
      console.log("Toggled mobileNav");
    } else {
      console.error("Mobile Nav element not found");
    }
  };

  if (mobileNav) {
    mobileNav.addEventListener("click", toggleNav);
    console.log("Event listener added to mobileNav");
  } else {
    console.error("Mobile Nav element not found on DOMContentLoaded");
  }
});
