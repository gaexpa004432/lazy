package admin.cms.menu.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuVO {
    private String menuId;			// 메뉴 아이디
    private String menuType;		// 메뉴 타입(H:홈페이지 / A:관리자)
    private String menuGbn;			// 메뉴 구분(C:컨텐츠 / B:게시판 / L:단순링크)
    private String menuLevel;		// 메뉴레벨
    private String menuNameKo;		// 한글 메뉴명
    private String menuNameEn;		// 영문 메뉴명
    private String menuNameCn;		// 중문 메뉴명
    private String menuNameJp;		// 일문 메뉴명
    private String parentMenu;		// 상위메뉴 아이디
    private String menuUrl;			// 메뉴주소 ( 단순링크일때만)
    private String contentId;		// 컨텐츠 아이디( 컨텐츠 메뉴 일때만)
    private String boardId;			// 게시판 아이디 ( 게시판 메뉴일때만)
    private String boardIdEn;		// 영문 아이디 ( 게시판 메뉴일때만)
    private String boardIdCn;		// 중문 아이디 ( 게시판 메뉴일때만)
    private String boardIdJp;		// 일문 아이디 ( 게시판 메뉴일때만)
    private String useYn;			// 사용여부
    private String blankYn;			// 새창여부
    private int	   sortOrder;		// 정렬순서
    private String menuYn;			// 메뉴표시여부
    private String regId;			// 등록자
    private String regDt;			// 등록일
    private String updId;			// 수정자
    private String updDt;			// 수정일
    private String menuIcon;		// 메뉴 아이콘
    private String parentTopMenu;	// 2차 메뉴 선택시 임시 1차 메뉴
    private String isLogin;			// 로그인 여부

    private int    pSortOrder;		// 상위메뉴 정렬순서
    private String groupId;			// 그룹아이디
    private String nowUrl;			// 현재 주소
    private String hasSub;			// 하위메뉴 존재여부
    private String regMode;			// 저장/수정모드
    private String[] adminGroup;	// 관리자 그룹 배열
    private String[] allowPages;	// 관련페이지 배열

    private String step1Name;		// 스탭1 메뉴 이름
    private String step2Name;		// 스탭2 메뉴 이름
    private String step3Name;		// 스탭3 메뉴 이름

}
