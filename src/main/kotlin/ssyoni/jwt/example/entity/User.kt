package ssyoni.jwt.example.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long? = null,

    @Column(name = "username", length = 50, unique = true)
    var username: String? = null,

    @Column(name = "password", length = 100)
    var password: String? = null,

    @Column(name = "nickname", length = 50)
    var nickname: String? = null,

    @Column(name = "activated")
    var isActivated: Boolean = false,

    @ManyToMany /* 사용자와 권한 테이블의 다대다 관계를 1:N, M:1 관계의 조인 테이블로 정의*/
    @JoinTable(
        name = "user_authority",
        joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "authority_name", referencedColumnName = "authority_name")]
    )
    var authorities: Set<Authority>? = null
)