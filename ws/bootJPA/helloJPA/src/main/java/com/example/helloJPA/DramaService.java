package com.example.helloJPA;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

////@Transactional
// → 영속성 컨텍스트가 유지됨
// → 엔티티가 영속성 컨텍스트에서 관리됨
// → 더티 체킹(변경 감지) 동작


 @Transactional
@Service
public class DramaService {

    private  final DramaRepository repository;


    public DramaService(DramaRepository repository) {
        this.repository = repository;
    }


    // 등록하기
    public  void   register( DramaRequest dramaRequest){
        Drama  drama =new Drama( dramaRequest);
        repository.save(drama);

    }


    //수정하기
    public  void   modify( DramaRequest dramaRequest){
        dramaRequest.setId(1l);
       // Drama  drama =new Drama( dramaRequest);
        Optional<Drama> dramaOptional=  repository.findById(dramaRequest.getId() ) ;
        Drama drama = dramaOptional.get();
        drama.setActors(dramaRequest.getActor()) ;

    }


    //하나 조회
    public DramaResponse findOne(Long id) {
        Drama drama = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("드라마 없음"));

        return new DramaResponse(drama);
    }

    public Optional<DramaResponse> findOne2(Long id) {
        return repository.findById(id)
                .map(DramaResponse::new); // 값이 없으면 Optional.empty() 반환
    }


    //   전체 조회
    public List<DramaResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(DramaResponse::new)
                .toList();
    }

 
    
    //삭제하기
    public  void deleteDrama(Long code){
        repository.deleteById(code);
    }



    //
// 페이징 조회

    @Transactional(readOnly = true)
    public Page<DramaResponse> findAllWithPaging(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .map(DramaResponse::new);   // Drama-> DramaResponse 생성
    }


    /*
    @Transactional(readOnly = true)
    public Page<DramaResponse> findAllWithPaging(int page, int size) {
        return repository.findAll(PageRequest.of(page, size))
                .map(drama -> new DramaResponse(drama));
    }
   */

}
