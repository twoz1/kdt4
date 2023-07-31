import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Body from './components/Body';
import Footer from './components/Footer';


//**import
//=>컴포넌트는 Mycomp from pathFile_path;
//  내부 코드에서 Mycomp 이름으로 인식
//=> css는 real_File_path만 적는다. 
//   import './Body.css'

function App() {
  const name = 'Green'
  // => 객체를 정의하고 Header 컴포넌트로 전달하고
  //    Header 컴포넌트에서 출력하기
  let user ={
    name : '햄스터'
  }
  const Naver = {
    name : '네이버',
    url : "https://www.naver.com/ "
  }

  return (
    <div className="App">
      {/* <Header user={user}/>
      <Body name={name}
      country = {'경기도 성남시'}/>
      <Footer /> */}
      {/* <h1 style={{
        background:'pink',
        color:'red'
      }}>
        Hello,{name}.
        <p>{3+5}</p>
        <p>{user.name}</p>
        <a href={Naver.url}>{Naver.name}</a>
        
      </h1> */}

    </div>

  );
}

export default App;
