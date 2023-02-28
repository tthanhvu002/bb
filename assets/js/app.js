const slider = document.querySelector(".slider");
const nextBtn = document.querySelector(".next-btn");
const prevBtn = document.querySelector(".prev-btn");
const width = document.querySelector(".slider .item").offsetWidth;
const mobileOverlay = document.querySelector('.mobile-overlay')
let i = 0;
slider.onscroll = () => {
  setColorBtn();
};
nextBtn.onclick = () => {
  slider.scrollLeft += width;
  setColorBtn();
};
prevBtn.onclick = () => {
  slider.scrollLeft -= width;
  setColorBtn();
};

approxeq = function (v1, v2, epsilon) {
  if (epsilon == null) {
    epsilon = 3;
  }
  return Math.abs(v1 - v2) < epsilon;
};

function setColorBtn() {
  if (slider.scrollLeft == 0) {
    prevBtn.classList.add("inactive");
    nextBtn.classList.remove("inactive");
  } else if (
    approxeq(slider.scrollLeft, slider.scrollWidth - slider.offsetWidth)
  ) {
    nextBtn.classList.add("inactive");
  } else {
    prevBtn.classList.remove("inactive");
  }
}
setColorBtn();

const mobileCateBtn = document.querySelector(".mobile-cate-btn");
const mobileCate = document.querySelector(".mobile-categories");
mobileCateBtn.onclick = (e) => {
  mobileCate.classList.toggle("active");
  mobileOverlay.classList.toggle('active')
};

/* mobileCate.onclick = () => {
  mobileCate.classList.add('active')
} */

const items = document.querySelectorAll(".list .item:nth-child(5n)");
items.forEach((item) => {
  item.classList.add("width-100");
});

const mobileDropdown = document.querySelectorAll(
  ".mobile-categories ul > .dropdown"
);

mobileDropdown.forEach((item) => {
  item.onclick = (e) => {
    e.stopPropagation()
    item.querySelector(".sub-dropdown").classList.toggle("active");
    item.querySelector('i').classList.toggle('active')
    console.log(item);
  };
});

const mobileSubDropdown = document.querySelectorAll(
  ".mobile-categories  .lv2-dropdown"
);

mobileSubDropdown.forEach((item) => {
  item.onclick = (e) => {

    e.stopPropagation()
    item.querySelector('.lv2-sub-dropdown').classList.toggle('active')
    item.querySelector('i').classList.toggle('active')

  };
});

const lv2Dropdown = document.querySelectorAll(
  ".categories  .lv2-dropdown"
);

lv2Dropdown.forEach((item) => {
  item.onclick = (e) => {

    e.stopPropagation()
    item.querySelector('.lv2-sub-dropdown').classList.toggle('active')
    item.style.height = "100%"
  };
});
