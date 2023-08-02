// function Header() {
//     return (
//         <header>
//             <h1>**Header**</h1>
//         </header>
//     );
// }
// export default Header;



// **1컴포넌트 1파일
// 그러므로 export default가 많이 사용됨.
import './Header.css'

export default function Header(props){
    return(
    <header>
        <h1>**Header**</h1>
        <p>{props.bestDress.color}</p>
        <p>size는 {props.bestDress.size.length}개가 있습니다.</p>
    </header>
    )
}
