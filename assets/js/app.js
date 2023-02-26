const slider = document.querySelector('.slider')
const nextBtn = document.querySelector('.next-btn')
const prevBtn = document.querySelector('.prev-btn')
const width = document.querySelector('.slider .item').offsetWidth
let i =0
slider.onscroll = () => {
  console.log(slider.scrollLeft);
  setColorBtn()
}
nextBtn.onclick = () => {
  slider.scrollLeft += width
  setColorBtn()
}
prevBtn.onclick = () => {
  
  slider.scrollLeft -= width
  setColorBtn()
}

approxeq = function(v1, v2, epsilon) {
  if (epsilon == null) {
    epsilon = 3;
  }
  return Math.abs(v1 - v2) < epsilon;
};

function setColorBtn(){
  if(slider.scrollLeft == 0){
    prevBtn.classList.add('inactive')
    nextBtn.classList.remove('inactive')
  } else if( approxeq( slider.scrollLeft,slider.scrollWidth - slider.offsetWidth )  ){
    nextBtn.classList.add('inactive')

  } else{
    prevBtn.classList.remove('inactive')


  }
}
setColorBtn()

const mobileCateBtn = document.querySelector('.mobile-cate-btn')
const mobileCate = document.querySelector('.mobile-categories')
mobileCateBtn.onclick = () => {
  mobileCate.classList.toggle('active')
}


const items = document.querySelectorAll('.list .item:nth-child(4n)')
items.forEach(item => {
  item.classList.add('width-100')
})