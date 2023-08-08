import './TodoItem.css';

const TodoItem = ({id, isDone, content, createDate}) => {
    return (
        <div className='TodoItem'>
            <div>
                <input type="checkbox" checked={isDone} />
            </div>

            <div className='title_col'>
                {content}
            </div>
            
            <div className='date_col'>
                {new Date(createDate).toLocaleDateString()}
                 {/* 타임스탬프 형식을 Date 형식으로 변환하고, 
        toLocaleDateString() 을 적용하여 문자열 로 랜더링 */}
            </div>

            <div className='btn_col'>
                <button>삭제</button>
            </div>
        </div>
    );
};

export default TodoItem;