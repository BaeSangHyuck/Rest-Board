# 구동방식
회원 로그인 시 헤더에 입력된 Authorization으로 사용회원을 검색하고 회원 및 비회원을 나눌 수 있습니다.
UserService에 있는 getUser메소드를 사용하여 Authorization에 있는 userId로 회원정보를 조회합니다.

<hr/>

### BoardController
BoardController는 게시글목록 조회, 게시글 조회, 게시글 등록, 게시글 수정, 게시글 삭제, 게시글 좋아요 누르기 기능을 가집니다.

* 게시글 목록 조회는 BoardService에 있는 getList를 사용하여 게시글들을 가져오며, getList 메소드에는 회원타입을 한글로 변경,
나의 좋아요 여부, 게시글 좋아요 개수 및 게시글 정보를 조회할 수 있습니다.

* 게시글 조회는 BoardService에 있는 getDetail메소드를 사용하여 나의 좋아요 여부, 게시글 좋아요 개수를 포함한 정보를 조회합니다.

* 게시글 업데이트는 BoardService에 있는 update메소드를 사용하며 boardNum으로 조회한 객체에 update메소드를 사용하여
수정시간과 정보를 트렌젝셔널로 묶어 변경감지를 사용해 수정합니다.

* 게시글 삭제는 업데이트와 같은 방식으로 구현되며, 현재 시간으로 삭제시간을 설정하고 deleteStatus를 1로 변경시킵니다.

* 게시글 좋아요는 jpa메소드인 exists를 사용하여 좋아요가 있는지 여부를 판단하고 있다면 delete 없다면 save메소드를
사용하도록 분기처리 하였습니다. 또한 좋아요가 되어있으면 true 되어있지 않다면 false를 리턴합니다.

<hr/>

### ReplyCotroller
ReplyCotroller는 댓글 목록 조회, 댓글 등록, 댓글 수정, 댓글 삭제 기능을 가집니다.

* 댓글 전체 조회는 조회중인 게시글의 번호인 boardNum을 이용하여 조회합니다.

* 댓글 작성은 입력한 댓글 정보를 입력하고 회원정보에는 Authorization을, 게시글 정보에는 boardNum을 이용하여 등록합니다.

* 댓글 수정기능은 등록방식과 같게 사용합니다.

* 댓글 삭제기능은 댓글정보를 조회하고 연관관계를 삭제한 후 삭제를 진행합니다.

<hr/>

만약 헤더에 Authorization이 존재하지 않는다면 비회원이며 비회원일 경우 getUser메소드에서 NullPointException이 뜨게되며
이 부분을 예외처리를 통해 UserNotFoundException클래스를 만들어 오류가 발생할 경우에 "회원이 아닙니다. 로그인 후 이용해주세요."
메세지가 발생하도록 구현하였습니다.
ExceptionController를 @ControllerAdvice어노테이션을 이용하여 모든 컨트롤러가 생성되기 전에  userNotFoundExceptionHandler를 만들어
모든 컨트롤러에서 공통으로 사용하도록 만들었습니다.

테스트 및 구현방식은
test폴더에 controller패키지에 테스트코드를 작성했습니다. 테스트 코드를 사용하시면 구현 가능할 것 같습니다.

<hr/>

마지막으로 사전과제를 진행하면서 모르는 부분을 많이 배울 수 있었으며, JPA뿐만 아니라 테스트 코드를 사용하는 법까지 배웠습니다.
좋은 기회주셔서 정말 감사합니다.

가능하다면 코드에 대한 피드백을 받을 수 있었으면 좋겠습니다. 감사합니다!!
