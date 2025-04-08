import { useState } from "react";
/*
미터를 입력해서 변화을 클릭하면 cm로 변환되는 코드를 작성하세요.
*/
function Convert(){
	let [amount, setAmount] = useState("");
	let [res, setRes] = useState(0);

	function convert(){
		setRes(amount*100);
	}
	return(
		<div>
			<div>
				<input type="number" value={amount} onChange={(e)=>setAmount(e.target.value)}/>
				<button onClick={convert}>변환</button>
			</div>
			<input type="number" value={res} readOnly/>
		</div>
	)
}

export default Convert;