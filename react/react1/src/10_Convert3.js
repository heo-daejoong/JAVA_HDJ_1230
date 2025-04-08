import { use, useState } from "react";
/*
변환버튼을 클릭하면 위 입력창이 쓰기모드로
다시 변환버튼을 클릭하면 아래 입력창이 쓰기모드로 변환되도록 작성

위 입력창에 m을 입력하면 cm로 입력하는 순간 변환하는 코드
아래 입력창에 cm을 입력하면 m로 입력하는 순간 변환하는 코드
*/
function Convert3(){
	let [flag, isFlag] = useState(false);
	let [amount, setAmount] = useState(0);
	/*let [amount1, setAmount1] = useState(0);
	let [res1, setRes1] = useState(0);

	function mToCm(e){
		setAmount1(e.target.value);
		setRes1(e.target.value*100);
	}
	function CmToM(e){
		setRes1(e.target.value);
		setAmount1(e.target.value/100);
	}
function convert(e){
	var value = e.target.value;
	if(flag){
		setRes1(value);
		setAmount1(value/100);
	}else{
		setRes1(value*100);
		setAmount1(value);
	}
}*/
	return(
		<div>
			<div>
				<input type="number" 
				disabled={flag} 
				onChange={e=>setAmount(e.target.value)} 
				value={!flag?amount : amount/100}
				/*onChange={mToCm}*/ /*onChange={convert} value={amount1}*//>
				<button onClick={()=>isFlag(!flag)}>변환</button>
			</div>
			<input type="number" 
			disabled={!flag} 
			onChange={e=>setAmount(e.target.value)} 
			value={flag?amount : amount*100}
			/*onChange={CmToM}*/ /*onChange={convert} value={res1}*//>
		</div>
	)
}

export default Convert3;